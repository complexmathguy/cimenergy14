/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Line business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Line related services in the case of a Line business related
 *       service failing.
 *   <li>Exposes a simpler, uniform Line interface to the business tier, making it easy for clients
 *       to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Line business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LineBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LineBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Line Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LineBusinessDelegate
   */
  public static LineBusinessDelegate getLineInstance() {
    return (new LineBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLine(CreateLineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLineId() == null) command.setLineId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LineValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLineCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO, "return from Command Gateway for CreateLineCommand of Line is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Line - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLine(UpdateLineCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Line - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLineCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLineCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLineCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Line using Id = " + command.getLineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Line via LineFetchOneSummary
   *
   * @param summary LineFetchOneSummary
   * @return LineFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Line getLine(LineFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("LineFetchOneSummary arg cannot be null");

    Line entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LineValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Line
      // --------------------------------------
      CompletableFuture<Line> futureEntity =
          queryGateway.query(
              new FindLineQuery(new LoadLineFilter(summary.getLineId())),
              ResponseTypes.instanceOf(Line.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Line with id " + summary.getLineId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Lines
   *
   * @return List<Line>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Line> getAllLine() throws ProcessingException {
    List<Line> list = null;

    try {
      CompletableFuture<List<Line>> futureList =
          queryGateway.query(new FindAllLineQuery(), ResponseTypes.multipleInstancesOf(Line.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Line";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add Line to Lines
   *
   * @param command AssignLinesToLineCommand
   * @exception ProcessingException
   */
  public void addToLines(AssignLinesToLineCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getLineId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires
            .delegate.LineBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .wires.delegate.LineBusinessDelegate.getLineInstance();
    LineBusinessDelegate parentDelegate = LineBusinessDelegate.getLineInstance();
    UUID childId = command.getAddTo().getLineId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Line as Lines to Line";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Line from Lines
   *
   * @param command RemoveLinesFromLineCommand
   * @exception ProcessingException
   */
  public void removeFromLines(RemoveLinesFromLineCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires
            .delegate.LineBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .wires.delegate.LineBusinessDelegate.getLineInstance();
    UUID childId = command.getRemoveFrom().getLineId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LineValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Line
   */
  private Line load(UUID id) throws ProcessingException {
    line = LineBusinessDelegate.getLineInstance().getLine(new LineFetchOneSummary(id));
    return line;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Line line = null;
  private static final Logger LOGGER = Logger.getLogger(LineBusinessDelegate.class.getName());
}
