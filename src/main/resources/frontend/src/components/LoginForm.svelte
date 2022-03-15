<script>
  import { goto } from '$app/navigation';
  import { API_URL, currentUser } from '../stores';

  let login = 'admin';
  let password = 'admin';

  const handleSubmit = async () => {
    try {
      const response = await fetch(`${$API_URL}/teller`);
      const users = await response.json();

      for (const user of users) {
        if (user.login === login && user.password === password) {
          $currentUser = user;
          goto('/');
        }
      }
    } catch (error) {
      console.log(error);
    }
  };
</script>

<form on:submit|preventDefault={handleSubmit}>
  <label for="login">Login</label>
  <input bind:value={login} type="text" name="login" placeholder="Login" required />

  <label for="password"> Password </label>
  <input bind:value={password} type="password" name="password" placeholder="Password" required />

  <small>Don't share your password with anybody.</small>

  <button type="submit">Submit</button>
</form>
