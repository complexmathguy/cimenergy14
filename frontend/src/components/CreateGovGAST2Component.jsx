import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service';

class CreateGovGAST2Component extends Component {
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
            GovGAST2Service.getGovGAST2ById(this.state.id).then( (res) =>{
                let govGAST2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovGAST2 = (e) => {
        e.preventDefault();
        let govGAST2 = {
                govGAST2Id: this.state.id,
            };
        console.log('govGAST2 => ' + JSON.stringify(govGAST2));

        // step 5
        if(this.state.id === '_add'){
            govGAST2.govGAST2Id=''
            GovGAST2Service.createGovGAST2(govGAST2).then(res =>{
                this.props.history.push('/govGAST2s');
            });
        }else{
            GovGAST2Service.updateGovGAST2(govGAST2).then( res => {
                this.props.history.push('/govGAST2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govGAST2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST2</h3>
        }else{
            return <h3 className="text-center">Update GovGAST2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST2}>Save</button>
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

export default CreateGovGAST2Component
