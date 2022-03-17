<script>
  import FaDollarSign from 'svelte-icons/fa/FaDollarSign.svelte';
  import { goto } from '$app/navigation';

  import { currentUser } from '../../stores';

  const currentUserName = $currentUser.name;

  const handleLogout = () => {
    $currentUser = '';
    goto('/');
  };
</script>

<nav class="container">
  <ul>
    <li>
      <div class="icon"><FaDollarSign /></div>
      <strong>{`${currentUserName ? currentUserName : 'LoanSystem'}`}</strong>
    </li>
  </ul>
  <ul>
    {#if !$currentUser}
      <li><a href="/login" role="button" class="secondary outline">Sign in</a></li>
      <li><a href="#" role="button">Sign up</a></li>
    {:else}
      <li><a href="/">Home</a></li>
      <li><a href="/customers">Customers</a></li>
      <li><span on:click={handleLogout} role="button" class="contrast">Logout</span></li>
    {/if}
  </ul>
</nav>

<style>
  .icon {
    color: var(--primary);
    width: 32px;
    height: 32px;
  }
  nav {
    height: 72px;
  }
  nav li:first-of-type {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    padding: 0;
  }
</style>
