import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService';

class UpdateExcSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcSK = this.updateExcSK.bind(this);

    }

    componentDidMount(){
        ExcSKService.getExcSKById(this.state.id).then( (res) =>{
            let excSK = res.data;
            this.setState({
            });
        });
    }

    updateExcSK = (e) => {
        e.preventDefault();
        let excSK = {
            excSKId: this.state.id,
        };
        console.log('excSK => ' + JSON.stringify(excSK));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcSKService.updateExcSK(excSK).then( res => {
            this.props.history.push('/excSKs');
        });
    }


    cancel(){
        this.props.history.push('/excSKs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcSK</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcSK}>Save</button>
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

export default UpdateExcSKComponent
