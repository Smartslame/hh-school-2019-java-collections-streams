package common;

import java.util.Objects;

public class ApiPersonDto {
  private String id;
  private Long created;
  private String name;
  private Integer areaId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getCreated() {
    return created;
  }

  public void setCreated(Long created) {
    this.created = created;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ApiPersonDto)) return false;
    ApiPersonDto that = (ApiPersonDto) o;
    return Objects.equals(getId(), that.getId()) &&
        Objects.equals(getCreated(), that.getCreated()) &&
        Objects.equals(getName(), that.getName()) &&
        Objects.equals(getAreaId(), that.getAreaId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCreated(), getName(), getAreaId());
  }
}
