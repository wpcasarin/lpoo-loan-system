<script>
  import { API_URL, currentCustomer, currentUser } from '../stores';

  export let id = 0;
  export let borrowed = 0;
  export let toReceive = 0;
  export let borrowedAt = '';
  export let expiresAt = '';
  let isOpen = false;
  let password = '';

  const fetchCustomer = async () => {
    try {
      const response = await fetch(`${$API_URL}/customer/${$currentCustomer.id}`);
      $currentCustomer = await response.json();
    } catch (error) {
      console.log(error);
    }
  };

  const handleDelete = async (id) => {
    if (password === $currentUser.password) {
      try {
        const response = await fetch(`${$API_URL}/loan/${id}`, {
          method: 'DELETE'
        });
        response.status === 200 ? fetchCustomer() : alert(`ERROR: ${response.status}`);
      } catch (error) {
        console.log(error);
      } finally {
        isOpen = false;
      }
    } else {
      alert('Wrong password!');
    }
  };
</script>

<dialog open="{isOpen}">
  <article>
    <h3>Confirm your password</h3>
    <input type="password" bind:value="{password}" />
    <footer>
      <a href="#cancel" role="button" class="secondary" on:click="{() => (isOpen = false)}">
        Cancel
      </a>
      <a href="#confirm" role="button" on:click="{() => handleDelete(id)}">Confirm</a>
    </footer>
  </article>
</dialog>

<details>
  <summary>Loan ID • <span>{id}</span></summary>
  <table>
    <thead>
      <tr>
        <th scope="col">Borrowed</th>
        <th scope="col">To Receive</th>
        <th scope="col">Borrowed Date</th>
        <th scope="col">Deadline</th>
        <th scope="col">#</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>{borrowed}$</td>
        <td>{toReceive}$</td>
        <td>{borrowedAt}</td>
        <td>{expiresAt}</td>
        <td>
          <button
            on:click="{() => {
              password = '';
              isOpen = true;
            }}">
            Pay
          </button>
        </td>
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
  button {
    padding: 0.09em 0.5em;
    margin: 0;
    background: rgb(1, 92, 27);
  }
  button:hover {
    background: hsl(137, 98%, 28%);
  }
</style>
