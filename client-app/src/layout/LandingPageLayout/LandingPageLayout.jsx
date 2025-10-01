import Footer from "../../component/footer/Footer"
import "./landing.css"
function LandingPageLayout({children}){
    return (
        <div className="landing-container">
            {children}
        </div>
    )
}
export default LandingPageLayout