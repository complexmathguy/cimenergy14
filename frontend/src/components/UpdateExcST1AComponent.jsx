import React, { Component } from 'react'
import ExcST1AService from '../services/ExcST1AService';

class UpdateExcST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcST1A = this.updateExcST1A.bind(this);

    }

    componentDidMount(){
        ExcST1AService.getExcST1AById(this.state.id).then( (res) =>{
            let excST1A = res.data;
            this.setState({
            });
        });
    }

    updateExcST1A = (e) => {
        e.preventDefault();
        let excST1A = {
            excST1AId: this.state.id,
        };
        console.log('excST1A => ' + JSON.stringify(excST1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST1AService.updateExcST1A(excST1A).then( res => {
            this.props.history.push('/excST1As');
        });
    }


    cancel(){
        this.props.history.push('/excST1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST1A}>Save</button>
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

export default UpdateExcST1AComponent
