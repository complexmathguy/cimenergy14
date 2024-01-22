import React, { Component } from 'react'
import CoordinateSystemService from '../services/CoordinateSystemService';

class UpdateCoordinateSystemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateCoordinateSystem = this.updateCoordinateSystem.bind(this);

    }

    componentDidMount(){
        CoordinateSystemService.getCoordinateSystemById(this.state.id).then( (res) =>{
            let coordinateSystem = res.data;
            this.setState({
            });
        });
    }

    updateCoordinateSystem = (e) => {
        e.preventDefault();
        let coordinateSystem = {
            coordinateSystemId: this.state.id,
        };
        console.log('coordinateSystem => ' + JSON.stringify(coordinateSystem));
        console.log('id => ' + JSON.stringify(this.state.id));
        CoordinateSystemService.updateCoordinateSystem(coordinateSystem).then( res => {
            this.props.history.push('/coordinateSystems');
        });
    }


    cancel(){
        this.props.history.push('/coordinateSystems');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CoordinateSystem</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCoordinateSystem}>Save</button>
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

export default UpdateCoordinateSystemComponent
