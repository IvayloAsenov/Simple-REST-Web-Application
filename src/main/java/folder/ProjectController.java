package folder;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.toilelibre.libe.curl.Curl.curl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @RequestMapping(method = GET, value = "/projects/{id}")
    public Project printProjectById(@PathVariable("id") String id) {
        String content = curl().lUpperCase().$(String.format("https://launch-pad-service.us-west-2.test.expedia.com/projects/%s", id));
        return new Project(content);
    }

    @RequestMapping(method = GET, value = "/projects")
    public Project printProjects() {
        String content = curl().lUpperCase().$("https://launch-pad-service.us-west-2.test.expedia.com/projects");
        return new Project(content);
    }

}
