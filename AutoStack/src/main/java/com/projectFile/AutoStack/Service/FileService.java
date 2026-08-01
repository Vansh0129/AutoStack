package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Project.FileContentResponse;
import com.projectFile.AutoStack.Dto.Project.FileNode;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface FileService {
    List<FileNode> GetTreeFile(Long projectId, long userId);

    FileContentResponse getFile(Long projectId, long userId, String path);
}
