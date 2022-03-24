<script>
  import FaMoneyBillWaveAlt from 'svelte-icons/fa/FaMoneyBillWaveAlt.svelte';
  import GiHistogram from 'svelte-icons/gi/GiHistogram.svelte';

  import NavBar from '../components/layout/NavBar.svelte';
  import Footer from '../components/layout/Footer.svelte';
  import LoanAccordion from '../components/LoanAccordion.svelte';
  import { API_URL, currentCustomer } from '../stores';

  const fetchCustomer = async () => {
    try {
      const response = await fetch(`${$API_URL}/customer/${$currentCustomer.id}`);
      $currentCustomer = await response.json();
    } catch (error) {
      console.log(error);
    }
  };

  $: $currentCustomer = fetchCustomer();
</script>

<NavBar />
<main class="container">
  <h1>
    {$currentCustomer.name}
    {$currentCustomer.lastName}
  </h1>
  {#if $currentCustomer.account}
    <section class="grid">
      <article>
        <div class="icon"><FaMoneyBillWaveAlt /></div>
        <h2>Limit <span>{$currentCustomer.account.loanLimit}</span>$</h2>
      </article>
      <article>
        <div class="icon"><GiHistogram /></div>
        <h2>Interest Rate <span>{$currentCustomer.account.loanTax * 100}</span>%</h2>
      </article>
    </section>

    {#each $currentCustomer.account.loans as loan}
      <LoanAccordion
        id="{loan.id}"
        borrowed="{loan.borrowed}"
        toReceive="{loan.toReceive}"
        borrowedAt="{loan.borrowedAt}"
        expiresAt="{loan.expiresAt}" />
    {/each}
  {:else}
    <h1 class="warning">User without account</h1>
  {/if}
</main>
<Footer />

<style>
  h2,
  h1 {
    margin: 0;
  }
  article {
    padding: 2rem 3rem;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 1rem;
  }
  span {
    color: var(--primary);
  }
  .icon {
    color: var(--primary-hover);
    width: 36px;
    aspect-ratio: 1;
  }
  .warning {
    color: var(--del-color);
  }
</style>
