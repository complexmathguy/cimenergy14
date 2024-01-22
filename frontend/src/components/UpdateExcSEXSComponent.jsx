import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService';

class UpdateExcSEXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcSEXS = this.updateExcSEXS.bind(this);

    }

    componentDidMount(){
        ExcSEXSService.getExcSEXSById(this.state.id).then( (res) =>{
            let excSEXS = res.data;
            this.setState({
            });
        });
    }

    updateExcSEXS = (e) => {
        e.preventDefault();
        let excSEXS = {
            excSEXSId: this.state.id,
        };
        console.log('excSEXS => ' + JSON.stringify(excSEXS));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcSEXSService.updateExcSEXS(excSEXS).then( res => {
            this.props.history.push('/excSEXSs');
        });
    }


    cancel(){
        this.props.history.push('/excSEXSs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcSEXS</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcSEXS}>Save</button>
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

export default UpdateExcSEXSComponent
