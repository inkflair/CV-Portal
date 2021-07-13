package com.inkflair.resumeportal;

import com.inkflair.resumeportal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController; // take response payload and sent it

import java.util.Optional;

@Controller // find template for it
public class HomeController {


    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit page";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUsername(userId);

        userProfile.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile.get());

        return "profile-templates/" + userProfile.get().getTheme() + "/index";
    }

}
