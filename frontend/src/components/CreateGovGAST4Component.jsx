import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service';

class CreateGovGAST4Component extends Component {
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
            GovGAST4Service.getGovGAST4ById(this.state.id).then( (res) =>{
                let govGAST4 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovGAST4 = (e) => {
        e.preventDefault();
        let govGAST4 = {
                govGAST4Id: this.state.id,
            };
        console.log('govGAST4 => ' + JSON.stringify(govGAST4));

        // step 5
        if(this.state.id === '_add'){
            govGAST4.govGAST4Id=''
            GovGAST4Service.createGovGAST4(govGAST4).then(res =>{
                this.props.history.push('/govGAST4s');
            });
        }else{
            GovGAST4Service.updateGovGAST4(govGAST4).then( res => {
                this.props.history.push('/govGAST4s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govGAST4s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST4</h3>
        }else{
            return <h3 className="text-center">Update GovGAST4</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST4}>Save</button>
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

export default CreateGovGAST4Component
