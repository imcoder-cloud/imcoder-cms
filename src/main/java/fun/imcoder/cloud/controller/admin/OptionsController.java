package fun.imcoder.cloud.controller.admin;

import fun.imcoder.cloud.base.BaseController;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.Options;
import fun.imcoder.cloud.service.OptionsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/options")
public class OptionsController extends BaseController<Options, OptionsService> {

    @GetMapping("/all")
    public ResponseData<Map<String, String>> all() {
        return ResponseData.success(ImcoderConfig.options);
    }

    @PutMapping("/save")
    public ResponseData<Boolean> save(@RequestBody Map<String, String> map) {
        List<Options> list = map.keySet().stream().collect(ArrayList<Options>::new, (l, o) -> {
            Options options = new Options();
            options.setOptionKey(o);
            options.setOptionValue(map.get(o));
            l.add(options);
        }, (m, u) -> new ArrayList<>());
        return ResponseData.success(this.service.save(list));
    }

}
