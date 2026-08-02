package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Project.FileContentResponse;
import com.projectFile.AutoStack.Dto.Project.FileNode;
import com.projectFile.AutoStack.Service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> GetTreeFile(Long projectId, long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFile(Long projectId, long userId, String path) {
        return null;
    }
}
