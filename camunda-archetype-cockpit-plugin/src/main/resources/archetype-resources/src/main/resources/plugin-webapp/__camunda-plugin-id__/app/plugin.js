function generateHTML(processInstanceCounts) {
  const body = processInstanceCounts
    .map(
      element => `<tr>
                    <td>${element.key}</td>
                    <td>${element.instanceCount}</td>
                  </tr>`
    )
    .join("\n");

  return `
<section>
  <div class="inner">
    <h3>${camunda-plugin-name}</h3>
    <table class="table table-bordered table-hover table-condensed">
      <thead>
        <tr>
          <th>Key</th>
          <th>Instances</th>
        </tr>
      </thead>
      <tbody>
        ${body}
      </tbody>
    </table>
  </div>
</section>`;
}

export default {
  id: "${camunda-plugin-id}",
  pluginPoint: "cockpit.processes.dashboard",
  priority: 12,
  render: (container, { cockpitApi, engine }) => {
    fetch(
      `${cockpitApi}/plugin/${camunda-plugin-id}/${engine}/process-instance`
    ).then(async res => {
      const processInstanceCounts = await res.json();
      container.innerHTML = generateHTML(processInstanceCounts);
    });
  }
};
