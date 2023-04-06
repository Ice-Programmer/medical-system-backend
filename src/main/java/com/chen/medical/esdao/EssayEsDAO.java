package com.chen.medical.esdao;

import com.chen.medical.model.dto.essay.EssayEsDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/6 21:02
 */
public interface EssayEsDAO extends ElasticsearchRepository<EssayEsDTO, Long> {

    List<EssayEsDTO> findByTitle(String title);
}
