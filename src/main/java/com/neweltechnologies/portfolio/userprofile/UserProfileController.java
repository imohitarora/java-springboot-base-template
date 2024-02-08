package com.neweltechnologies.portfolio.userprofile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neweltechnologies.portfolio.base.BaseController;

@RestController
@RequestMapping("userprofile")
public class UserProfileController extends BaseController<Long, UserProfile, UserProfileDTO> {

    private final UserProfileService service;

    public UserProfileController(UserProfileService userProfileService) {
        super(userProfileService);
        this.service = userProfileService;
    }

}
