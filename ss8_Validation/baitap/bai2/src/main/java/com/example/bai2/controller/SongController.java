package com.example.bai2.controller;

import com.example.bai2.dto.SongDto;
import com.example.bai2.entity.Song;
import com.example.bai2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final ISongService service;

    public SongController(ISongService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("songs", service.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("songDto")SongDto songDto,
                         BindingResult bindingResult, RedirectAttributes redirect){
        if(bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        service.save(song);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/songs";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Song song = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy bài hát với id: " + id));

        SongDto dto = new SongDto();
        BeanUtils.copyProperties(song, dto);

        model.addAttribute("songDto", dto);
        model.addAttribute("id", song.getId());
        return "update";
    }


    @PostMapping("/update/{id}")
    public String update( @PathVariable Integer id,
                          @Validated @ModelAttribute("songDto") SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("id", id);
            return "update";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        song.setId(id);

        service.save(song);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/songs";
    }
}
