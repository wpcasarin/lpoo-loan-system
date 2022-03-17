<script script>
  import { goto } from '$app/navigation';

  import { API_URL, currentCustomer, currentUser } from '../stores';

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

  const handleLoanButton = (customer) => {
    $currentCustomer = customer;
    goto('/loan');
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
      <th scope="col">#</th>
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
          <td>
            <button on:click="{() => handleLoanButton(customer)}">Loan</button>
          </td>
        </tr>
      {/each}
    {/await}
  </tbody>
</table>

<style>
  button {
    padding: 0.1em 1.2em;
  }
</style>
