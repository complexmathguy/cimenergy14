import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service';

class CreateGovGAST1Component extends Component {
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
            GovGAST1Service.getGovGAST1ById(this.state.id).then( (res) =>{
                let govGAST1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovGAST1 = (e) => {
        e.preventDefault();
        let govGAST1 = {
                govGAST1Id: this.state.id,
            };
        console.log('govGAST1 => ' + JSON.stringify(govGAST1));

        // step 5
        if(this.state.id === '_add'){
            govGAST1.govGAST1Id=''
            GovGAST1Service.createGovGAST1(govGAST1).then(res =>{
                this.props.history.push('/govGAST1s');
            });
        }else{
            GovGAST1Service.updateGovGAST1(govGAST1).then( res => {
                this.props.history.push('/govGAST1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govGAST1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST1</h3>
        }else{
            return <h3 className="text-center">Update GovGAST1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST1}>Save</button>
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

export default CreateGovGAST1Component
