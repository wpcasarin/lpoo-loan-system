<script script>
  import { API_URL, currentUser } from '../stores';

  const fetchCustomers = async () => {
    const telerId = $currentUser.id;
    try {
      const response = await fetch(`${$API_URL}/teller/${telerId}`);
      const teller = await response.json();
      return teller.customers;
    } catch (error) {
      console.log(error);
    }
  };
</script>

<table>
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">CPF</th>
      <th scope="col">Score</th>
      <th scope="col">Paycheck</th>
    </tr>
  </thead>
  <tbody>
    {#await fetchCustomers() then customers}
      {#each customers as customer}
        <tr>
          <th scope="row">{customer.id}</th>
          <td>{customer.name}</td>
          <td>{customer.lastName}</td>
          <td>{customer.cpf}</td>
          <td>{customer.score}</td>
          <td>{customer.paycheck}</td>
        </tr>
      {/each}
    {/await}
  </tbody>
</table>
