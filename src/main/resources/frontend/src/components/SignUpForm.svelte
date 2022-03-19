<script>
  import { goto } from '$app/navigation';
  import { API_URL } from '../stores';

  let name = 'test';
  let lastName = 'test';
  let cpf = '00.000.000.00';
  let email = 'test@test.com';
  let birthdate = '1990-01-01';
  let login = 'test';
  let password = 'test';

  const cpfMask = (value) => {
    return value
      .replace(/\D/g, '')
      .replace(/(\d{3})(\d)/, '$1.$2')
      .replace(/(\d{3})(\d)/, '$1.$2')
      .replace(/(\d{3})(\d{1,2})/, '$1-$2')
      .replace(/(-\d{2})\d+?$/, '$1');
  };

  const handleSubmit = async () => {
    try {
      const data = {
        name,
        lastName,
        cpf,
        email,
        birthdate,
        login,
        password
      };
      const response = await fetch(`${$API_URL}/teller`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      response.status === 200 ? goto('/') : alert(`ERROR: ${response.status}`);
    } catch (error) {
      console.log(error);
    }
  };
</script>

<form on:submit|preventDefault="{handleSubmit}">
  <label for="name">Name</label>
  <input bind:value="{name}" type="text" name="name" placeholder="Name" required />

  <label for="lastName">Last Name</label>
  <input bind:value="{lastName}" type="text" name="lastName" placeholder="Last Name" required />

  <label for="email">Email</label>
  <input bind:value="{email}" type="email" name="email" placeholder="Email" required />

  <label for="cpf">CPF</label>
  <input
    bind:value="{cpf}"
    on:change="{() => (cpf = cpfMask(cpf))}"
    type="text"
    name="cpf"
    placeholder="999.999.999-99"
    maxlength="14"
    required />

  <label for="email">Birthdate</label>
  <input bind:value="{birthdate}" type="date" name="birthdate" placeholder="Birthdate" required />

  <label for="login">Login</label>
  <input bind:value="{login}" type="text" name="login" placeholder="Login" required />

  <label for="password"> Password </label>
  <input bind:value="{password}" type="password" name="password" placeholder="Password" required />

  <small>Don't share your password with anybody.</small>

  <button type="submit">Submit</button>
</form>
