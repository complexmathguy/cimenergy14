import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService';

class UpdateEquivalentBranchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquivalentBranch = this.updateEquivalentBranch.bind(this);

    }

    componentDidMount(){
        EquivalentBranchService.getEquivalentBranchById(this.state.id).then( (res) =>{
            let equivalentBranch = res.data;
            this.setState({
            });
        });
    }

    updateEquivalentBranch = (e) => {
        e.preventDefault();
        let equivalentBranch = {
            equivalentBranchId: this.state.id,
        };
        console.log('equivalentBranch => ' + JSON.stringify(equivalentBranch));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentBranchService.updateEquivalentBranch(equivalentBranch).then( res => {
            this.props.history.push('/equivalentBranchs');
        });
    }


    cancel(){
        this.props.history.push('/equivalentBranchs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentBranch</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentBranch}>Save</button>
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

export default UpdateEquivalentBranchComponent
