import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService';

class CreateGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovGASTWDService.getGovGASTWDById(this.state.id).then( (res) =>{
                let govGASTWD = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovGASTWD = (e) => {
        e.preventDefault();
        let govGASTWD = {
                govGASTWDId: this.state.id,
            };
        console.log('govGASTWD => ' + JSON.stringify(govGASTWD));

        // step 5
        if(this.state.id === '_add'){
            govGASTWD.govGASTWDId=''
            GovGASTWDService.createGovGASTWD(govGASTWD).then(res =>{
                this.props.history.push('/govGASTWDs');
            });
        }else{
            GovGASTWDService.updateGovGASTWD(govGASTWD).then( res => {
                this.props.history.push('/govGASTWDs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govGASTWDs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGASTWD</h3>
        }else{
            return <h3 className="text-center">Update GovGASTWD</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGASTWD}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateGovGASTWDComponent
