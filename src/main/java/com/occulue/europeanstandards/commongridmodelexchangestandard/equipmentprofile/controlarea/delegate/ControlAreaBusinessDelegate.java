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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.validator.*;
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
 * ControlArea business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ControlArea related services in the case of a ControlArea
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ControlArea interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ControlArea business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ControlAreaBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ControlAreaBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ControlArea Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ControlAreaBusinessDelegate
   */
  public static ControlAreaBusinessDelegate getControlAreaInstance() {
    return (new ControlAreaBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createControlArea(CreateControlAreaCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getControlAreaId() == null) command.setControlAreaId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlAreaValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateControlAreaCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateControlAreaCommand of ControlArea is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ControlArea - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateControlAreaCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateControlArea(UpdateControlAreaCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ControlAreaValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateControlAreaCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ControlArea - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteControlAreaCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteControlAreaCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlAreaValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteControlAreaCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ControlArea using Id = " + command.getControlAreaId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ControlArea via ControlAreaFetchOneSummary
   *
   * @param summary ControlAreaFetchOneSummary
   * @return ControlAreaFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ControlArea getControlArea(ControlAreaFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ControlAreaFetchOneSummary arg cannot be null");

    ControlArea entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ControlAreaValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ControlArea
      // --------------------------------------
      CompletableFuture<ControlArea> futureEntity =
          queryGateway.query(
              new FindControlAreaQuery(new LoadControlAreaFilter(summary.getControlAreaId())),
              ResponseTypes.instanceOf(ControlArea.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ControlArea with id " + summary.getControlAreaId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ControlAreas
   *
   * @return List<ControlArea>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ControlArea> getAllControlArea() throws ProcessingException {
    List<ControlArea> list = null;

    try {
      CompletableFuture<List<ControlArea>> futureList =
          queryGateway.query(
              new FindAllControlAreaQuery(), ResponseTypes.multipleInstancesOf(ControlArea.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ControlArea";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign ControlArea on ControlArea
   *
   * @param command AssignControlAreaToControlAreaCommand
   * @exception ProcessingException
   */
  public void assignControlArea(AssignControlAreaToControlAreaCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getControlAreaId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea
            .delegate.ControlAreaBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .controlarea.delegate.ControlAreaBusinessDelegate.getControlAreaInstance();
    ControlAreaBusinessDelegate parentDelegate =
        ControlAreaBusinessDelegate.getControlAreaInstance();
    UUID childId = command.getAssignment().getControlAreaId();
    ControlArea child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ControlAreaValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ControlArea using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ControlArea on ControlArea
   *
   * @param command UnAssignControlAreaFromControlAreaCommand
   * @exception ProcessingException
   */
  public void unAssignControlArea(UnAssignControlAreaFromControlAreaCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ControlAreaValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ControlArea on ControlArea";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ControlArea
   */
  private ControlArea load(UUID id) throws ProcessingException {
    controlArea =
        ControlAreaBusinessDelegate.getControlAreaInstance()
            .getControlArea(new ControlAreaFetchOneSummary(id));
    return controlArea;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ControlArea controlArea = null;
  private static final Logger LOGGER =
      Logger.getLogger(ControlAreaBusinessDelegate.class.getName());
}
