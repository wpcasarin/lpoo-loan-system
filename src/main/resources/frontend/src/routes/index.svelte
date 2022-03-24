<script>
  import Footer from '../components/layout/Footer.svelte';
  import NavBar from '../components/layout/NavBar.svelte';
</script>

<NavBar />
<main>
  <div class="hero">
    <div class="container">
      <h1>Welcome to LoanSystem</h1>
      <h4>Making rich people richer and poor people even poorer since 1990.</h4>
    </div>
  </div>
</main>
<Footer />

<style>
  :global(body) {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }
  .container {
    padding-top: 3rem;
  }
  h1 {
    color: white;
    font-weight: bold;
    font-size: 5rem;
  }
  h4 {
    color: white;
    font-size: 1.5rem;
    padding-inline-end: 20rem;
  }
  .hero {
    background: url('../../static/hero.jpg');
    background-repeat: no-repeat;
    background-size: cover;
    height: 33rem;
  }
</style>
