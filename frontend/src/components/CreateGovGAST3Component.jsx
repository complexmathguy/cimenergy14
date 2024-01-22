import React, { Component } from 'react'
import GovGAST3Service from '../services/GovGAST3Service';

class CreateGovGAST3Component extends Component {
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
            GovGAST3Service.getGovGAST3ById(this.state.id).then( (res) =>{
                let govGAST3 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovGAST3 = (e) => {
        e.preventDefault();
        let govGAST3 = {
                govGAST3Id: this.state.id,
            };
        console.log('govGAST3 => ' + JSON.stringify(govGAST3));

        // step 5
        if(this.state.id === '_add'){
            govGAST3.govGAST3Id=''
            GovGAST3Service.createGovGAST3(govGAST3).then(res =>{
                this.props.history.push('/govGAST3s');
            });
        }else{
            GovGAST3Service.updateGovGAST3(govGAST3).then( res => {
                this.props.history.push('/govGAST3s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govGAST3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST3</h3>
        }else{
            return <h3 className="text-center">Update GovGAST3</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST3}>Save</button>
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

export default CreateGovGAST3Component
