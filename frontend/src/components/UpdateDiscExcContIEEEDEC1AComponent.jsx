import React, { Component } from 'react'
import DiscExcContIEEEDEC1AService from '../services/DiscExcContIEEEDEC1AService';

class UpdateDiscExcContIEEEDEC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiscExcContIEEEDEC1A = this.updateDiscExcContIEEEDEC1A.bind(this);

    }

    componentDidMount(){
        DiscExcContIEEEDEC1AService.getDiscExcContIEEEDEC1AById(this.state.id).then( (res) =>{
            let discExcContIEEEDEC1A = res.data;
            this.setState({
            });
        });
    }

    updateDiscExcContIEEEDEC1A = (e) => {
        e.preventDefault();
        let discExcContIEEEDEC1A = {
            discExcContIEEEDEC1AId: this.state.id,
        };
        console.log('discExcContIEEEDEC1A => ' + JSON.stringify(discExcContIEEEDEC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscExcContIEEEDEC1AService.updateDiscExcContIEEEDEC1A(discExcContIEEEDEC1A).then( res => {
            this.props.history.push('/discExcContIEEEDEC1As');
        });
    }


    cancel(){
        this.props.history.push('/discExcContIEEEDEC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiscExcContIEEEDEC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscExcContIEEEDEC1A}>Save</button>
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

export default UpdateDiscExcContIEEEDEC1AComponent
