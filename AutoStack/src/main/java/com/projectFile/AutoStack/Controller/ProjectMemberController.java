package com.projectFile.AutoStack.Controller;




import com.projectFile.AutoStack.Dto.Member.InviteMemberRequest;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import com.projectFile.AutoStack.Dto.Project.UpdateMemberRequest;
import com.projectFile.AutoStack.Service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)        //This add private final to fields
public class ProjectMemberController {

     ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> GetAllMembers(@PathVariable Long projectId){
        Long userId=2l;
        return ResponseEntity.ok(projectMemberService.GetAllMembers(projectId,userId));

    }

    @PostMapping
    public ResponseEntity<MemberResponse> InviteMember(@PathVariable Long projectId,@RequestBody InviteMemberRequest request){
        Long userId=2l;
        return   ResponseEntity
                .status(HttpStatus.CREATED)
                .body(projectMemberService.InviteMember(projectId,userId,request));

    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponse> UpdateMemberRole(
            @PathVariable Long projectId,
            @RequestBody UpdateMemberRequest request,
            @PathVariable Long memberId
            ) {
        Long userId = 2l;
        return ResponseEntity.ok(projectMemberService.UpdateRole(projectId, memberId, request, userId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> DeleteProjectMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId
    ) {
        Long userId = 2l;
        return   ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(projectMemberService.DeleteProjectMember(projectId,memberId,userId));
    }




}
