package com.projectFile.AutoStack.Controller;

import com.projectFile.AutoStack.Dto.Project.FileContentResponse;
import com.projectFile.AutoStack.Dto.Project.FileNode;
import com.projectFile.AutoStack.Service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private  final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> GetTreeFile(@PathVariable Long projectId){
        long userId=1l;
        return ResponseEntity.ok(fileService.GetTreeFile(projectId,userId));
    }

    @GetMapping("/{*path}") // src/hook/component/app.jsx --> *path -> give remaining path
    public ResponseEntity<FileContentResponse> getFileContent(@PathVariable Long projectId, @PathVariable String path){
        long userId=1l;
        return ResponseEntity.ok(fileService.getFile(projectId,userId,path));
    }
}
