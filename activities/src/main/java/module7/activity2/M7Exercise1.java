package module7.activity2;
//
//import java.util.List;
//
//public class M7Exercise1 {
//	private Long id;
//	private String name;
//	private String group;
//	private List<String> apiCallsMade;
//	
//	public M7Exercise1() {}
//	
//	public M7Exercise1(Long id, String name, String group, List<String> apiCallsMade) {
//		this.id = id;
//		this.name = name;
//		this.group = group;
//		this.apiCallsMade = apiCallsMade;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGroup() {
//		return group;
//	}
//	public void setGroup(String group) {
//		this.group = group;
//	}
//	public List<String> getApiCallsMade() {
//		return apiCallsMade;
//	}
//	public void setApiCallsMade(List<String> apiCallsMade) {
//		this.apiCallsMade = apiCallsMade;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	
//	
//}



import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Represents a profile entity with basic information and API call history")
public class M7Exercise1 {

    @Schema(
        description = "Unique identifier for the profile",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Name of the person",
        example = "Jose Rizal"
    )
    private String name;

    @Schema(
        description = "Group affiliation of the person",
        example = "Illustrados"
    )
    private String group;

    @Schema(
        description = "List of API calls made by this profile",
        example = "[\"GET: /profiles\", \"POST: /profiles\"]"
    )
    private List<String> apiCallsMade;

    public M7Exercise1() {}

    public M7Exercise1(Long id, String name, String group, List<String> apiCallsMade) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.apiCallsMade = apiCallsMade;
    }

    @Schema(description = "Gets the name of the profile")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Schema(description = "Gets the group affiliation of the profile")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Schema(description = "Gets the list of API calls made by this profile")
    public List<String> getApiCallsMade() {
        return apiCallsMade;
    }

    public void setApiCallsMade(List<String> apiCallsMade) {
        this.apiCallsMade = apiCallsMade;
    }

    @Schema(description = "Gets the unique identifier of the profile")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

