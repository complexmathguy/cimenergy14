import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService';

class CreateEquivalentBranchComponent extends Component {
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
            EquivalentBranchService.getEquivalentBranchById(this.state.id).then( (res) =>{
                let equivalentBranch = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquivalentBranch = (e) => {
        e.preventDefault();
        let equivalentBranch = {
                equivalentBranchId: this.state.id,
            };
        console.log('equivalentBranch => ' + JSON.stringify(equivalentBranch));

        // step 5
        if(this.state.id === '_add'){
            equivalentBranch.equivalentBranchId=''
            EquivalentBranchService.createEquivalentBranch(equivalentBranch).then(res =>{
                this.props.history.push('/equivalentBranchs');
            });
        }else{
            EquivalentBranchService.updateEquivalentBranch(equivalentBranch).then( res => {
                this.props.history.push('/equivalentBranchs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equivalentBranchs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquivalentBranch</h3>
        }else{
            return <h3 className="text-center">Update EquivalentBranch</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquivalentBranch}>Save</button>
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

export default CreateEquivalentBranchComponent
