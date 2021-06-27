package com.maison.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maison.wiki.entity.Ebook;
import com.maison.wiki.entity.EbookExample;
import com.maison.wiki.mapper.EbookMapper;
import com.maison.wiki.req.EbookReq;
import com.maison.wiki.resp.EbookResp;
import com.maison.wiki.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

//    @Autowired spring的 @Resource jdk自带的
    @Resource
    private EbookMapper ebookMapper;

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(1,3);
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("page total => {}" + pageInfo.getTotal());
        LOG.info("page pages => {}" + pageInfo.getPages());

//        ArrayList<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList) {
////            EbookResp ebookResp = new EbookResp();
////            BeanUtils.copyProperties(ebook,ebookResp);
//            单个复制
//            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }
//        列表复制
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
        return list;
    }

}
