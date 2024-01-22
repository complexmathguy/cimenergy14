import React, { Component } from 'react'
import PssELIN2Service from '../services/PssELIN2Service';

class UpdatePssELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssELIN2 = this.updatePssELIN2.bind(this);

    }

    componentDidMount(){
        PssELIN2Service.getPssELIN2ById(this.state.id).then( (res) =>{
            let pssELIN2 = res.data;
            this.setState({
            });
        });
    }

    updatePssELIN2 = (e) => {
        e.preventDefault();
        let pssELIN2 = {
            pssELIN2Id: this.state.id,
        };
        console.log('pssELIN2 => ' + JSON.stringify(pssELIN2));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssELIN2Service.updatePssELIN2(pssELIN2).then( res => {
            this.props.history.push('/pssELIN2s');
        });
    }


    cancel(){
        this.props.history.push('/pssELIN2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssELIN2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssELIN2}>Save</button>
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

export default UpdatePssELIN2Component
