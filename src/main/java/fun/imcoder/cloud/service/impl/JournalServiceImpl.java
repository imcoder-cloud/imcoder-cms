package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.JournalMapper;
import fun.imcoder.cloud.model.Journal;
import fun.imcoder.cloud.service.JournalService;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl extends BaseServiceImpl<JournalMapper, Journal> implements JournalService {
}
