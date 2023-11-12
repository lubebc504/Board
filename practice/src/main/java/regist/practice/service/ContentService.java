package regist.practice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import regist.practice.domain.Content;
import regist.practice.repository.ContentRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public void writeContent(Content content){
        contentRepository.save(content);
    }

    public void editContent(int id, String texts,String password){
        Content content=contentRepository.findById(id);
        if(!content.getPassword().equals(password)){
            return;
        }

        content.setTexts(texts);

        LocalDateTime now=LocalDateTime.now();
        String formattedDate=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        content.setUpdateDate(formattedDate);

        contentRepository.edit(content);
    }

    public void deleteContent(int id, String password) {
        Content content = contentRepository.findById(id);
        if(!content.getPassword().equals(password)) {
            return;
        }
        contentRepository.delete(id);
    }

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public Content getContent(int id) {
        return contentRepository.findById(id);
    }

    public void Testing(){
        contentRepository.test();
    }
}
