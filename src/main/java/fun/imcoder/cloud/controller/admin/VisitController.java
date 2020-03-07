package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.model.Visit;
import fun.imcoder.cloud.service.VisitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitController extends BaseController<Visit, VisitService> {

}
