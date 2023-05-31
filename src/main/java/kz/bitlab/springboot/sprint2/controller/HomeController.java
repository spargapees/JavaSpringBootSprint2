package kz.bitlab.springboot.sprint2.controller;

import kz.bitlab.springboot.sprint2.db.ApplicationRequest;
import kz.bitlab.springboot.sprint2.db.DBManager;
import kz.bitlab.springboot.sprint2.db.Music;
import kz.bitlab.springboot.sprint2.dbconnect.RequestManager;
import kz.bitlab.springboot.sprint2.model.RequestModel;
import kz.bitlab.springboot.sprint2.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RequestManager manager;

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(value = "/") // @WebServlet(value = "/") + doGet()
    public String indexPage(Model model){
        List<RequestModel> requsetModelList = requestRepository.findAll();
        model.addAttribute("zaprosy", requsetModelList);
        return "index";
    }

    @GetMapping(value = "/new") // @WebServlet(value = "/") + doGet()
    public String indexPageNew(Model model){
            List<RequestModel> requsetModelList = requestRepository.findAllByHandledIsFalse();
        model.addAttribute("zaprosy", requsetModelList);
        return "index";

    }

    @GetMapping(value = "/old") // @WebServlet(value = "/") + doGet()
    public String indexPageOld(Model model){
        List<RequestModel> requsetModelList = requestRepository.findAllByHandledIsTrue();
        model.addAttribute("zaprosy", requsetModelList);
        return "index";

    }

    @PostMapping(value = "/save-request")
    public String saveRequest(RequestModel requestModel){
        requestRepository.save(requestModel);
        return "redirect:/"; // response.sendRedirect("/");
    }

    @PostMapping(value = "/delete-request")
    public String deleteRequest(@RequestParam(name="id") Long id){
        requestRepository.deleteById(id);
        return "redirect:/"; // response.sendRedirect("/");
    }

    @PostMapping(value = "/add-request")
    public String addRequest(RequestModel requsetModel){
        requestRepository.save(requsetModel);
        return "redirect:/";
    }

    @PostMapping(value = "/add-music-v2")
    public String addMusicV2(
            //String name = request.getParameter("music-name");
            @RequestParam(name = "music-name") String name,
            @RequestParam(name = "music-author") String author,
            @RequestParam(name = "music-duration") int duration
    ){
        Music music = new Music();
        music.setName(name);
        music.setAuthor(author);
        music.setDuration(duration);
        DBManager.addMusic(music);

        return "redirect:/"; // response.sendRedirect("/");
    }

    @GetMapping(value = "/request-details")
    public String getRequest(@RequestParam(name = "requestId") Long id,
                           Model model){
        RequestModel requsetModel = requestRepository.findById(id).orElse(null);
        model.addAttribute("zapros", requsetModel);
        return "requestdetails";
    }

    @GetMapping(value = "/add-request")
    public String addRequestPage(Model model){
        return "addrequest";
    }

    @GetMapping(value = "/details/{requestId}")
    public String requestDetails(@PathVariable(name = "requestId") Long id, Model model){
        RequestModel requsetModel = requestRepository.findById(id).orElse(null);
        model.addAttribute("zapros", requsetModel);
        return "requestdetails";
    }

}