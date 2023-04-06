package com.chen.medical.esdao;

import com.chen.medical.model.dto.essay.EssayEsDTO;
import io.lettuce.core.ScriptOutputType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/6 21:01
 */
@SpringBootTest
public class EssayEsDtoTest {

    @Resource
    private EssayEsDAO essayEsDAO;

    @Test
    void testAdd() {
        EssayEsDTO essayEsDTO = new EssayEsDTO();
        essayEsDTO.setId(1L);
        essayEsDTO.setTitle("如何治疗秃头");
        essayEsDTO.setContent("秃顶会对心理造成很严重的伤害，治疗秃顶脱发，首先需要找到正确的病因后，对症治疗，若是由于生活习惯不当引起的脱发，首先需要做到合理饮食和日常的护理，同时也要避免熬夜，需要维持充足的睡眠时间，若是由于疾病或遗传因素引起，应选择正确治疗或植发来解决秃顶问题。");
        essayEsDTO.setArticle("秃顶是指大量脱发、头发生长速度低于脱落速度，而在头顶形成一块明显的无发区域。目前脱发秃顶已不是中年大叔们的标配了，很多年轻人也深受秃顶的困扰，不止该如何解决这个令人尴尬的问题，那么到底秃顶怎么治疗才好？\n" +
                "　　一、找准病因\n" +
                "　　秃顶是因为大量脱发形成的，治疗秃顶首先需要找到正确的脱发原因，若是因为工作压力过大、生活作息不良引起的，因改善这类问题，若是疾病因素或遗传因素治疗，可选择治疗和植发等，应找准病因后对症治疗。\n" +
                "　　二、合理饮食\n" +
                "　　大部分人脱发秃顶都跟饮食有关，经常脱发的人群日常可以多食用含有蛋白质和微量元素的食物，比如青菜、水果、芝麻等食物，需要避免食用过于油腻的食物，比如含糖量高、煎炸、辛辣类食物等。\n" +
                "　　三、做好日常护理\n" +
                "　　头发也需要做好日常护理才可以避免脱发，首先日常需要养成勤洗头、保持头发干净不潮湿以及多梳头的习惯。日常洗头发的次数应该在2~3天一次，洗完头发后需要彻底将头发烘干，烘干后需要多梳梳头发，按摩头皮，帮助促进血液循环，防止脱发。\n" +
                "　　四、注意休息\n" +
                "　　若休息时间过少，也会导致头发大量的脱落，充足的睡眠可以帮助毛发正常新陈代谢，若是睡眠时间不够，就会导致头发的代谢和营养过度流失，当营养失去平衡以后，就会影响头发的生长，因此一定要保证自己拥有充足的睡眠。\n" +
                "　　以上便是关于秃顶怎么治疗的详细回答，想要更好的预防脱发和治疗秃顶，不仅需要日常的护理和休息，也需要做到正确治疗，切勿盲目使用生发产品，防止脱发情况越加严重。");
        essayEsDTO.setAuthor("陈嘉翰");
        essayEsDTO.setPath("/Users/chenjiahan/项目开发/医学文献智能识别与检索系统设计/01.JPG");
        essayEsDTO.setTags(Arrays.asList("秃头", "皮肤科"));
        essayEsDTO.setCreateTime(new Date());
        essayEsDTO.setUpdateTime(new Date());
        essayEsDTO.setIsDelete(0);
        essayEsDAO.save(essayEsDTO);
        System.out.println(essayEsDTO.getId());
    }

    @Test
    void testSelect() {
        List<EssayEsDTO> essayEsDTOS = essayEsDAO.findByTitle("秃头");
        System.out.println(essayEsDTOS);
    }
}
