import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService';

class CreateGovGASTComponent extends Component {
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
            GovGASTService.getGovGASTById(this.state.id).then( (res) =>{
                let govGAST = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovGAST = (e) => {
        e.preventDefault();
        let govGAST = {
                govGASTId: this.state.id,
            };
        console.log('govGAST => ' + JSON.stringify(govGAST));

        // step 5
        if(this.state.id === '_add'){
            govGAST.govGASTId=''
            GovGASTService.createGovGAST(govGAST).then(res =>{
                this.props.history.push('/govGASTs');
            });
        }else{
            GovGASTService.updateGovGAST(govGAST).then( res => {
                this.props.history.push('/govGASTs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govGASTs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST</h3>
        }else{
            return <h3 className="text-center">Update GovGAST</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST}>Save</button>
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

export default CreateGovGASTComponent
