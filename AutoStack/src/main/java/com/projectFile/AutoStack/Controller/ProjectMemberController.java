package com.projectFile.AutoStack.Controller;




import com.projectFile.AutoStack.Dto.Member.InviteMemberRequest;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import com.projectFile.AutoStack.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

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
    public ResponseEntity<MemberResponse> UpdateRole(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequest request,
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
