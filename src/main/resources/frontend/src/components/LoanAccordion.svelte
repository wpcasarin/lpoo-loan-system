<script>
  export let id = 0;
  export let borrowed = 0;
  export let toReceive = 0;
  export let borrowedAt = '';
  export let expiresAt = '';
</script>

<details>
  <summary>Loan ID • <span>{id}</span></summary>
  <table>
    <thead>
      <tr>
        <th scope="col">Borrowed</th>
        <th scope="col">To Receive</th>
        <th scope="col">Borrowed Date</th>
        <th scope="col">Deadline</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>{borrowed}$</td>
        <td>{toReceive}$</td>
        <td>{borrowedAt}</td>
        <td>{expiresAt}</td>
      </tr>
    </tbody>
  </table>
</details>

<style>
  th {
    font-weight: bold;
  }
  span {
    color: var(--primary);
    font-weight: bold;
  }
</style>
