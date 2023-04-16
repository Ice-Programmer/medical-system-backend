package com.chen.medical.esdao;

import com.chen.medical.model.dto.essay.EssayEsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
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
        essayEsDTO.setId(7L);
        essayEsDTO.setTitle("FOCUS 超声刀开放性甲状腺切除术的临床疗效评价");
        essayEsDTO.setContent("目的 探讨 FOCUS 超声刀开放性甲状腺切除术的临床疗效及应用价值。方法 选择 2009 年 7 月— 2011 年 5 月在我院内分泌血管外科住院手术治疗的 199 例甲状腺疾病患者作为研究对象，其中传统甲状腺切除术 ( 传 统组) 110 例，FOCUS 超声刀甲状腺切除术 ( FOCUS 超声刀组) 89 例，分别从切口大小、手术时间、术中出血量、术 后 24 h 伤口引流量、手术并发症发生率及术后住院时间进行对比分析。结果 FOCUS 超声刀组患者手术均获成功，手 术平均时间 (42.33±10.72) min，术中平均出血量 (18.96±11.83) ml，术后24h伤口平均引流量 (25.28±18.91) ml，术后平均住院时间 ( 5. 50 ± 1. 22) d，与传统组比较，差异均有统计学意义 ( P < 0. 05) 。FOCUS 超声刀组术后出 血 ( 0 例) 、一过性声音嘶哑 ( 0 例) 、一过性饮水呛咳 ( 0 例) 、暂时性低钙抽搐及麻木 ( 0 例) 的发生率分别与传统 组比较，差异均有统计学意义 ( P < 0. 05) 。结论 FOCUS 超声刀在甲状腺切除术中具有明显优势，其并发症少，安 全、有效，操作灵活，易于掌握，值得在今后的临床工作中予以推广。");
        essayEsDTO.setArticle("Clinical Evaluation of FOCUS Ultrasound Scalpel in Open Thyroidectomy XUE Jia - peng，WANG Ming - hua，WANG Geng，et al. Department of Endocrine and Vascular Surgery，the Affiliated Taihe Hospital of Hubei University of Medicine，Shiyan 442000，China\n" +
                "【Abstract】 Objective To study the clinical effect and application value of FOCUS ultrasound scalpel in open thyroid- ectomy. Methods Patients underwent thyroid operation in our department from July 2009 to May 2011 were selected as study ob- jects，including 110 cases of conventional thyroidectomy and 89 cases of ultrasound scalpel thyroidectomy. The comparative analy- sis was made in terms of incision size，operation time，blood loss，postoperative drainage 24 h after operation，post - operative complications and postoperative hospitalized time. Results No statistically significant difference was found between the two groups in such aspects as gender，age，disease formation，tumor size and surgical methods ( P > 0. 05) . All the 89 cases of ultrasound scalpel thyroidectomy were successful，the mean operation time was ( 42. 33 ± 10. 72) min，mean blood loss was ( 18. 96 ± 11. 83) ml，the average postoperative drainage after 24 h was ( 25. 28 ± 18. 91) ml，mean postoperative hospitalized time was ( 5. 50 ± 1. 22) d. The difference was statistically significant compared with those of the conventional group ( P < 0. 05) . In ul- trasound scalpel group，no cases showed postoperative blood loss，hoarse voice，drinking bucking，temporary cramp. The differ- ence was statistically significant compared with those of the conventional group ( P < 0. 05) . Conclusion Compared with con- ventional method，FOCUS ultrasound scalpel has obvious advantages in thyroidectomy with fewer complications. As a method with more flexibility and facility，its application can be promoted clinically.\n" +
                "【Key words】 FOCUS ultrasound scalpel; Thyroidectomy; Treatment outcome\n" +
                "超声刀是近年来逐渐被广泛使用的一种新型手术器械，与 传统高频电刀相比，具有集切割、止血于一体，热损伤小，无 烟雾，术野清晰，无神经肌肉电刺激等优点[1]。FOCUS 超声 刀为新一代刀头，因价格昂贵，推广应用受限，其临床应用价 值和使用技巧相关报道不多。本研究将使用 FOCUS 超声刀进 行甲状腺切除术与同期传统手术方式 ( 以电刀结合丝线结扎 为主要止血方式) 比较分析，选取主要指标进行临床应用评 价，现报道如下。\n" +
                "1 资料与方法 1. 1 一般资料\n" +
                "作者单位: 分泌血管外科\n" +
                "王明华，442000 湖北省十堰市，湖北医药学院附属太 和医院内分泌血管外科; E - mail: wangmh1970@ sina. com\n" +
                "血管外科住院手术治疗甲状腺疾病患者 199 例，其中男 91 例， 女 108 例，年龄 18 ~ 76 岁，平均 46. 5 岁。患者均为初次手 术，其中采取传统甲状腺切除术 ( 传统组) 110 例，FOCUS 超声刀甲状腺切除术 ( FOCUS 超声刀组) 89 例。术后病理诊 断: 结节性甲状腺肿105例 (单侧23例，双侧82例)，甲状 腺腺瘤 36 例，结节性甲状腺肿合并甲状腺癌 13 例，甲状腺乳 头状癌 27 例 ( 包括甲状腺微小癌 6 例) ，原发性甲状腺功能 亢进18例 (II度肿大11例，III度肿大7例)。手术方式: 单 侧甲状腺大部/部分切除术 65 例，双侧甲状腺次全切除术 26 例，单侧甲状腺全切加峡部加对侧部分 / 次全切除术 80 例，甲 状腺全切除术/根治切除术 28 例。两组一般资料间有可比性 ( 见表 1) 。\n" +
                "选择 2009 年 7 月—2011 年 5 月在我院内分泌 442000 湖北省十堰市，湖北医药学院附属太和医院内\n" +
                "·641· ·论著·\n" +
                " 通讯作者:\n" +
                "主要器械为美国强生公司生产 GEN 300，工作振动频率 55. 5\n" +
                "1. 2 超声刀器械及应用管理\n" +
                "的 FOCUS 超声刀，型号规格: kHz，剪刀式刀柄，刀头呈弯血管钳形状。器械管理由专人负 责，刀头在每次使用后予以拆卸，严格清洗晾干、封袋、环氧\n" +
                " ·642·\n" +
                "乙烷消毒后备用，并对刀头进行定期抽查，细菌培养，结果均 为阴性。\n" +
                "1. 3 手术方法 两组患者均采用气管插管静脉复合麻醉方法， 手术步骤基本一致。选取颈前低位领口状顺皮纹切口，手术刀 切开皮肤，沿颈阔肌下方游离皮瓣，纵行切开颈白线及甲状腺 外被膜，暴露甲状腺及包块，在包膜与固有膜之间的疏松层内 钝性分离腺叶。结合术中探查及术前彩超确定病变部位及大 小，决定 FOCUS 超声刀切除线路及范围。先在甲状腺峡部上 方游离锥体叶，使用电刀凝闭锥体叶、峡叶上部与气管之间的 小血管，然后用 FOCUS 超声刀凝闭峡叶下方气管前血管，FO- CUS 超声刀、电刀交替切断峡部腺体。用血管钳向外侧牵拉甲 状腺，电刀切开甲状腺与气管之间的纤维组织，以及部分 Ber- ry 韧带，向外下侧牵拉甲状腺，用 FOCUS 超声刀凝闭切断甲 状腺悬韧带，借用传统手术 “囊内法”游离并切断甲状腺下极 血管，在甲状软骨下角水平以前平面。再使用 FOCUS 超声刀 从甲状腺下极内侧面开始，由下向上切断甲状腺与气管之间的 纤维组织及部分未切断的 Berry 韧带，至上极时，紧贴甲状腺 上极凝闭甲状腺上动静脉，最后凝闭甲状腺中静脉，此时患侧 甲状腺已大部游离，按预定切除范围切除甲状腺。彻底止血， 手术残腔放置细硅胶引流管，可吸收线缝合颈白线及颈阔肌， 切口使用 3 - 0 滑线连续皮内缝合法美容缝合，结束手术。\n" +
                "1. 4 指标的观察与记录 比较两组切口大小、手术时间、术 中出血量、术后 24 h 伤口引流量、手术并发症发生率及术后 住院时间等。记录切口长度; 手术时间从切开皮肤到缝合切口 结束的时间; 术中出血量为负压吸引瓶中及使用纱布完全湿透 估计值的总和 ( 术中每块纱布完全湿透估计失血量约为 50 ml) ; 术后 24 h 伤口引流量为从放置到拔除引流管之间的引流 量 ( 一次性记总量) ，若术后引流量 < 10 ml 时当天拔除引流 管; 手术并发症包括术后出血、声音嘶哑，饮水呛咳、低钙性 抽搐及麻木等，对于有术后并发症者均随访 6 个月以上，3 个 月内恢复者视为一过性损伤，超过 6 个月仍未恢复者视为永久 性损伤。\n" +
                "1. 5 统计学方法 采用 SPSS 17. 0 统计软件包进行统计学处 理，计量资料以 ( x ± s) 表示，组间比较采用 t 检验; 计数 资料采用 χ2 检验。P < 0. 05 为差异有统计学意义。\n" +
                "2结果\n" +
                "2. 1 两组观察指标的比较 FOCUS 超声刀组患者的手术时 间、术中出血量、术后 24 h 伤口引流量及术后住院时间分别 与传统组比较，差异均有统计学意义 ( P < 0. 05) ; FOCUS 超 声刀组切口大小与传统组比较，差异无统计学意义 ( P > 0.05，见表2)。\n" +
                "2. 2 两组患者术后并发症的比较 FOCUS 超声刀组术后出 血、一过性声音嘶哑、一过性饮水呛咳、暂时性低钙抽搐及麻 木的发生率分别与传统组比较，差异均有统计学意义 ( P < 0. 05) ，而 FOCUS 超声刀组术后永久性声音嘶哑及永久性甲状 旁腺功能减退分别与传统组比较，差异无统计学意义 ( P > 0.05，见表3)。\n" +
                "3讨论 随着甲状腺新手术理念和技术的转变，新的手术器械的应\n" +
                "用也越来越广泛。20 世纪 90 年代后，超声刀被引入外科手 术，并由于其诸多优点很快受到甲状腺外科医生的青睐，但旧 式刀头操作灵活性较差，与颈前部区域狭小、手术视野范围有 限不相适应。而 FOCUS 超声刀是由美国强生公司 2008 年推出 的新一代刀头，其优点为: ( 1) 提高离断组织和血管速度;\n" +
                "( 2) 切割凝闭同时完成; ( 3) 一器多用代替其他手术工具;\n" +
                "( 4) 安全关闭 5 mm 以下血管及淋巴管; ( 5) 有分离组织功 能[2]。由于 FOCUS 超声刀为持剪式操作，其刀头为弯血管钳 形状，使术中操作变得更加精细、灵活，分离及解剖组织方便 易行，初学者更易于掌握; 又由于 FOCUS 超声刀产热热度及 热传导比高频电刀要小，一般在 50 ~ 100 °C ，可减少对甲状腺 周围邻近神经、气管及甲状旁腺的直接损伤及热损伤。FOCUS 超声刀的边凝边切及分离功能等特点使术者极大减少器械更换 频率，并缩短手术时间，在很多部位可以代替传统手术分离、 结扎、缝合等操作方法。\n" +
                "表 1 两组患者一般资料的比较\n" +
                "Table 1 Comparison of clinical data between two groups\n" +
                "   性别 (男/女)\n" +
                "39 /50\n" +
                "52 /58\n" +
                "0. 236\n" +
                "P值 0.627 0.124 0.444\n" +
                "病理诊断( 例) 结节性 甲状腺\n" +
                "手术方式( 例) 单侧全\n" +
                "组别 例数\n" +
                "FOCUS 超声刀组 89 传统组 110\n" +
                "注:* 为t值，余检验统计量值为χ2 值\n" +
                "组别 例数\n" +
                "FOCUS 超声刀组 89 传统组 110\n" +
                "t 值 P 值\n" +
                "甲状腺\n" +
                "结节性甲 甲状腺 肿合并 癌乳头 甲状腺功 单侧大\n" +
                "年龄 (岁)\n" +
                "45. 13 ± 11. 73\n" +
                "肿瘤大小 (cm)\n" +
                "3. 25 ± 1. 87\n" +
                "切加峡\n" +
                "部加对 全切除 侧部分 术/根治 切除术 切除术\n" +
                "状腺肿 腺瘤\n" +
                "49 16\n" +
                "56 20\n" +
                "甲状腺癌 状癌\n" +
                "5 12\n" +
                "8 15 0. 616\n" +
                "0.961\n" +
                "能亢进\n" +
                "7\n" +
                "11\n" +
                "部 / 部分\n" +
                "30 12\n" +
                "35 45\n" +
                "术后住院 时间( d)\n" +
                "5. 50 ± 1. 22 8.98 ±1.54\n" +
                "1. 593\n" +
                "0. 012\n" +
                "双侧次 切除术 全切除术\n" +
                "35 14\n" +
                "术后 24 h 伤口 引流量( ml)\n" +
                "25. 28 ± 18. 91 60.51 ±24.67\n" +
                "1. 702\n" +
                "0. 005\n" +
                " 47. 84 ± 12. 69 -1. 549*\n" +
                "3. 06 ± 1. 62 0. 768*\n" +
                "12 16\n" +
                "     检验统计量值\n" +
                "0. 145\n" +
                "0.986\n" +
                " 表2 两组观测指标的比较 ( x ±s)\n" +
                "Table 2 Comparison of observation indexes between two groups\n" +
                " 切口大小 ( cm)\n" +
                "4. 05 ± 0. 83\n" +
                "5.02 ±0.86\n" +
                "1. 074\n" +
                "0. 366\n" +
                "手术时间 ( min)\n" +
                "42. 33 ± 10. 72\n" +
                "59.64 ±13.89\n" +
                "1. 679\n" +
                "0. 006\n" +
                "术中出血量 ( ml)\n" +
                "18. 96 ± 11. 83\n" +
                "43.21 ±15.39\n" +
                "1. 692\n" +
                "0. 005\n" +
                "    \n" +
                " Table 3 术后出血\n" +
                "( 血肿)\n" +
                "8( 7. 27)\n" +
                "4.991\n" +
                "< 0. 05\n" +
                "表 3 两组患者术后并发症的比较 [n ( %) ] Comparison of operative complications between two groups\n" +
                "·643·\n" +
                " 组别 例数\n" +
                "一过性声 永久性声 一过性饮 音嘶哑 音嘶哑 水呛咳\n" +
                "暂时性低钙 抽搐及麻木\n" +
                "永久性甲状旁\n" +
                "腺功能减退 FOCUS超声刀组 89 0 0 0 0 0 0\n" +
                " 传统组 110\n" +
                "χ2 值 P 值\n" +
                "7( 6. 36)\n" +
                "4.145\n" +
                "< 0. 05\n" +
                "2( 1. 82)\n" +
                "0.318\n" +
                "> 0. 05\n" +
                "7( 6. 36)\n" +
                "4.145\n" +
                "< 0. 05\n" +
                "8( 7. 27)\n" +
                "4.991\n" +
                "< 0. 05\n" +
                "2( 1. 82)\n" +
                "0.318\n" +
                "> 0. 05\n" +
                "   从解剖特点上看，甲状腺血供丰富，血管在腺体表面和腺 体内广泛分支并互相吻合成网状; 喉返神经紧邻下极血管，沿 气管食管沟上行，多在甲状腺下动脉的分支间穿过; 喉上神经 在被膜外与上动脉伴行，内支在上极处入喉，支配喉黏膜感 觉，手术过程中均易造成损伤，因此妥善止血及避免神经损伤 一直是甲状腺外科的一个重要课题。传统手术多行缝线结扎及 电凝止血，操作繁琐、费时，还有缝线脱落及施夹夹闭血管时 夹子脱落或移位的风险，并且电凝设备工作温度高达 150 ~ 400°C，热效应可达2.5~4.0mm[3]，易损伤周围组织。鉴于 此弊端，本研究对 FOCUS 超声刀与传统甲状腺切除手术的临 床疗效进行对比分析，评价其推广价值。\n" +
                "因 FOCUS 超声刀的应用在手术过程中减少了器械更换， 使手术更为流畅，缩短了手术时间，FOCUS 超声刀组平均手 术时间控制在 45 min 内，并取得非常满意的手术效果，降低 了麻醉及手术风险。与传统手术比较，术中出血量显著减少， 特别针对甲状腺功能亢进患者，优势更加明显，甲状腺功能亢 进患者的甲状腺腺体充血水肿较为明显，即使术前充分的服碘 准备，也不能完全达到无充血状态，这就对术中止血要求较 高，而常因术中广泛渗血及出血令术者措手不及。由于甲状腺 腺体组织的血管、淋巴管、胶原纤维及弹力纤维纵横交错，腺 管含丰富蛋白，故 FOCUS 超声刀切割的同时可使腺体组织凝 固收缩形成较为牢固的创面，从而解决甲状腺功能亢进及甲状 腺恶性肿瘤患者术中易出血的问题，使术野更加清晰、干净， 同时 FOCUS 超声刀凝固切断甲状腺上动脉时，均不需丝线结 扎。再加上 FOCUS 超声刀具有手指延伸作用，可拓展手术操 作空间，降低了对充分暴露及解剖上极血管的要求，缩小了手 术伤口及创面，也降低了部分患者甲状腺上极组织延伸过高的 手术难度，使手术时间显著缩短。本研究发现 89 例患者行 FOCUS 超声刀手术，术中无一例止血失败，不需丝线结扎及 电凝等辅助止血，不存在线结残留，解决了由于遗留结扎线而 导致炎症反应的增加，加重组织粘连，影响切口愈合，形成较 明显的手术瘢痕，进一步影响颈部美容的问题，术后也无结节 感、异物感、牵拉及疼痛感等。本研究结果显示，FOCUS 超 声刀组术后 24 h 伤口引流量及术后住院时间较传统组明显减 少及缩短，引流量在 25 ml 左右，平均住院时间缩短至 5 d ( 包括患者入院后术前准备及相关检查需要 2 d 时间) 。说明应 用 FOCUS 超声刀术后恢复更快，于术后 24 h 颈部引流管即可 拔除，又由于术中创面整齐、异物反应轻，炎症及瘢痕粘连较 少，减轻了手术给患者带来的痛苦和自身的损伤，在一定程度 上降低了二次手术的难度，加快了患者术后康复，更加符合手 术微创化的要求。\n" +
                "甲状腺手术的术后并发症一直是困扰外科医生的难题，因\n" +
                "FOCUS 超声刀手术切割过程中组织无明显出血，创面渗血少， 无烟雾，无焦痂形成，使手术在一个几乎无血的环境中进行， 术野十分清晰，这为显露喉返神经及甲状旁腺提供了有利条 件，可在直视下进行甲状腺手术操作，确保术者对解剖辨认及 操作的准确性，减少了对喉返神经及甲状旁腺等重要结构的损 伤。国外研究显示，应用超声刀对喉返神经损伤概率并无影 响，但超声刀热损伤小，对周围组织的热传导不超过 3. 0 mm[4]，因此在游离组织时是安全的。本研究中 FOCUS 超声刀 组术后无一例发生切口出血或血肿形成、声音嘶哑、饮水呛 咳、低钙性抽搐及麻木等，其并发症的发生率明显低于传统 组，该结果也低于国内外报道[5]。通过本研究体会到甲状软 骨下角水平以前平面切割凝断 Berry 韧带及上极，可以很好地 保护喉上神经; 术中如清晰辨认喉返神经，可使用剥离子或超 声刀轻轻向后方推移，超声刀工作面朝上切割; 如未见喉返神 经，不要刻意解剖，可以很好地防止喉返神经热损伤; 在切除 甲状腺背侧时，尽量使用切割功能，能有效保护甲状旁腺损 伤。根据相关文献报道超声刀开放性甲状腺切除术并不能完全 避免手术并发症的发生，特别是喉返神经及甲状旁腺损 伤[5-6]，而本研究结果显示应用FOCUS超声刀无一例术后发 生并发症，该原因可能与样本量较少有关。\n" +
                "FOCUS 超声刀作为一种新的技术优势，具有良好的应用 价值及临床疗效，并且安全、有效，术后伤口愈合快，瘢痕 小，体现了美容效果，同时又没有明显增加患者的医疗负担， 因此值得在今后的临床工作中予以推广。\n" +
                "参考文献\n" +
                "1 王军成，范玉琢，王吉军，等 . 超声刀联合电刀行肝切除 13 例分 析 [J]. 中国误诊学杂志，2010，10 ( 27) : 6763.\n" +
                "2 刘清波，王卫东，吴志强，等 . FOCUS 超声刀在小切口甲状腺手 术中的应用 [J]. 岭南现代临床外科，2010，10 ( 1) : 29 - 30.\n" +
                "3 Karvounaris DC，Antonopoulos V，Psarras K，et al. Efficacy and safe-\n" +
                "ty of ultrasonically activated shears in thyroid surgery [J]. Head Neck，\n" +
                "2006，28 ( 11) : 1028 - 1031.\n" +
                "4 Barczyński M，Konturek A，Cichoń S. Minimally invasive video - assis-\n" +
                "ted thyreoidectomy ( MIVAT) with and without use of harmonic scalpela randomized study [J]. Langenbecks Arch Surg，2008，393 ( 5 ) : 647 - 654.\n" +
                "5 杨熙鸿，彭汉伟，刘木元，等 . 超声刀 FOCUS 在开放性甲状腺手 术中的应用 [J]. 汕头大学医学院学报，2010，23 ( 1) : 42 - 44.\n" +
                "6 汤治平 . 超声刀在甲状腺开放手术中应用 506 例分析 [J]. 中华 普通外科学文献 ( 电子版) ，2007，1 ( 14) : 215 - 217.\n" +
                "( 收稿日期: 2011 -07 -25; 修回日期: 2011 -11 -16) ( 本文编辑: 张小龙)");
        essayEsDTO.setAuthor("薛家鹏，王明华，王 耕，赵宗彬");
        essayEsDTO.setPath("/Users/chenjiahan/项目开发/医学文献智能识别与检索系统设计/pdf/FOCUS超声刀开放性甲状腺切除术的临床疗效评价_薛家鹏.pdf");
        essayEsDTO.setTags(Arrays.asList("FOCUS 超声刀", "甲状腺切除术", "治疗结果"));
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
