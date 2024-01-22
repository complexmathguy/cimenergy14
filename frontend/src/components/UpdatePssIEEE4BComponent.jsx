import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService';

class UpdatePssIEEE4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssIEEE4B = this.updatePssIEEE4B.bind(this);

    }

    componentDidMount(){
        PssIEEE4BService.getPssIEEE4BById(this.state.id).then( (res) =>{
            let pssIEEE4B = res.data;
            this.setState({
            });
        });
    }

    updatePssIEEE4B = (e) => {
        e.preventDefault();
        let pssIEEE4B = {
            pssIEEE4BId: this.state.id,
        };
        console.log('pssIEEE4B => ' + JSON.stringify(pssIEEE4B));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssIEEE4BService.updatePssIEEE4B(pssIEEE4B).then( res => {
            this.props.history.push('/pssIEEE4Bs');
        });
    }


    cancel(){
        this.props.history.push('/pssIEEE4Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssIEEE4B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssIEEE4B}>Save</button>
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

export default UpdatePssIEEE4BComponent
