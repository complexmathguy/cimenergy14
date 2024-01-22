import React, { Component } from 'react'
import SeasonService from '../services/SeasonService';

class UpdateSeasonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSeason = this.updateSeason.bind(this);

    }

    componentDidMount(){
        SeasonService.getSeasonById(this.state.id).then( (res) =>{
            let season = res.data;
            this.setState({
            });
        });
    }

    updateSeason = (e) => {
        e.preventDefault();
        let season = {
            seasonId: this.state.id,
        };
        console.log('season => ' + JSON.stringify(season));
        console.log('id => ' + JSON.stringify(this.state.id));
        SeasonService.updateSeason(season).then( res => {
            this.props.history.push('/seasons');
        });
    }


    cancel(){
        this.props.history.push('/seasons');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Season</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSeason}>Save</button>
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

export default UpdateSeasonComponent
