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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.validator.*;
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
 * TextDiagramObject business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TextDiagramObject related services in the case of a
 *       TextDiagramObject business related service failing.
 *   <li>Exposes a simpler, uniform TextDiagramObject interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TextDiagramObject business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TextDiagramObjectBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TextDiagramObjectBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TextDiagramObject Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TextDiagramObjectBusinessDelegate
   */
  public static TextDiagramObjectBusinessDelegate getTextDiagramObjectInstance() {
    return (new TextDiagramObjectBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTextDiagramObject(CreateTextDiagramObjectCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTextDiagramObjectId() == null)
        command.setTextDiagramObjectId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TextDiagramObjectValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTextDiagramObjectCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTextDiagramObjectCommand of TextDiagramObject is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TextDiagramObject - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTextDiagramObjectCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTextDiagramObject(UpdateTextDiagramObjectCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TextDiagramObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTextDiagramObjectCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TextDiagramObject - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTextDiagramObjectCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTextDiagramObjectCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TextDiagramObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTextDiagramObjectCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TextDiagramObject using Id = " + command.getTextDiagramObjectId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TextDiagramObject via TextDiagramObjectFetchOneSummary
   *
   * @param summary TextDiagramObjectFetchOneSummary
   * @return TextDiagramObjectFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TextDiagramObject getTextDiagramObject(TextDiagramObjectFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TextDiagramObjectFetchOneSummary arg cannot be null");

    TextDiagramObject entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TextDiagramObjectValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TextDiagramObject
      // --------------------------------------
      CompletableFuture<TextDiagramObject> futureEntity =
          queryGateway.query(
              new FindTextDiagramObjectQuery(
                  new LoadTextDiagramObjectFilter(summary.getTextDiagramObjectId())),
              ResponseTypes.instanceOf(TextDiagramObject.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TextDiagramObject with id " + summary.getTextDiagramObjectId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TextDiagramObjects
   *
   * @return List<TextDiagramObject>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TextDiagramObject> getAllTextDiagramObject() throws ProcessingException {
    List<TextDiagramObject> list = null;

    try {
      CompletableFuture<List<TextDiagramObject>> futureList =
          queryGateway.query(
              new FindAllTextDiagramObjectQuery(),
              ResponseTypes.multipleInstancesOf(TextDiagramObject.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TextDiagramObject";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Text on TextDiagramObject
   *
   * @param command AssignTextToTextDiagramObjectCommand
   * @exception ProcessingException
   */
  public void assignText(AssignTextToTextDiagramObjectCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTextDiagramObjectId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TextDiagramObjectBusinessDelegate parentDelegate =
        TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TextDiagramObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Text on TextDiagramObject
   *
   * @param command UnAssignTextFromTextDiagramObjectCommand
   * @exception ProcessingException
   */
  public void unAssignText(UnAssignTextFromTextDiagramObjectCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TextDiagramObjectValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Text on TextDiagramObject";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TextDiagramObject
   */
  private TextDiagramObject load(UUID id) throws ProcessingException {
    textDiagramObject =
        TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
            .getTextDiagramObject(new TextDiagramObjectFetchOneSummary(id));
    return textDiagramObject;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TextDiagramObject textDiagramObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(TextDiagramObjectBusinessDelegate.class.getName());
}
