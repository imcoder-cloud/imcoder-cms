package fun.imcoder.cloud.service.impl;

import fun.imcoder.cloud.base.BaseServiceImpl;
import fun.imcoder.cloud.mapper.AttachmentMapper;
import fun.imcoder.cloud.model.Attachment;
import fun.imcoder.cloud.service.AttachmentService;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {
}
