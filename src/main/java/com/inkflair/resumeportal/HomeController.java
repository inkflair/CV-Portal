package com.inkflair.resumeportal;

import com.inkflair.resumeportal.models.Job;
import com.inkflair.resumeportal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController; // take response payload and sent it

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller // find template for it
public class HomeController {


    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String home() {

        Optional<UserProfile> profile1 = userProfileRepository.findByUsername("einstein");
        profile1.orElseThrow(() -> new RuntimeException("Not found"));
        Job job1 = new Job();
        job1.setCompany("Company 1");
        job1.setDesignation("Designation");
        job1.setId(1);
        job1.setEndDate(LocalDate.of(2020, 1, 1));
        job1.setStartDate(LocalDate.of(2023, 1,1));
        job1.setCurrentJob(true);
        Job job2 = new Job();
        job2.setCompany("Company 2");
        job2.setDesignation("Designation");
        job2.setId(2);
        job2.setEndDate(LocalDate.of(2020, 1, 1));
        job2.setStartDate(LocalDate.of(2023, 1,1));


        profile1.get().getJobs().clear();
        profile1.get().getJobs().add(job1);
        profile1.get().getJobs().add(job2);

        userProfileRepository.save(profile1.get());
        return "profile";
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

        System.out.println(userProfile.get().getJobs());

        return "profile-templates/" + userProfile.get().getTheme() + "/index";
    }

}
