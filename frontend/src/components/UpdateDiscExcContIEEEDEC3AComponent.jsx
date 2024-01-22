import React, { Component } from 'react'
import DiscExcContIEEEDEC3AService from '../services/DiscExcContIEEEDEC3AService';

class UpdateDiscExcContIEEEDEC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiscExcContIEEEDEC3A = this.updateDiscExcContIEEEDEC3A.bind(this);

    }

    componentDidMount(){
        DiscExcContIEEEDEC3AService.getDiscExcContIEEEDEC3AById(this.state.id).then( (res) =>{
            let discExcContIEEEDEC3A = res.data;
            this.setState({
            });
        });
    }

    updateDiscExcContIEEEDEC3A = (e) => {
        e.preventDefault();
        let discExcContIEEEDEC3A = {
            discExcContIEEEDEC3AId: this.state.id,
        };
        console.log('discExcContIEEEDEC3A => ' + JSON.stringify(discExcContIEEEDEC3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscExcContIEEEDEC3AService.updateDiscExcContIEEEDEC3A(discExcContIEEEDEC3A).then( res => {
            this.props.history.push('/discExcContIEEEDEC3As');
        });
    }


    cancel(){
        this.props.history.push('/discExcContIEEEDEC3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiscExcContIEEEDEC3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscExcContIEEEDEC3A}>Save</button>
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

export default UpdateDiscExcContIEEEDEC3AComponent
